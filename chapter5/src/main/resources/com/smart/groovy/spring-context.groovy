import com.smart.groovy.LogDao
import com.smart.groovy.DbUserDao
import com.smart.groovy.LogonService
import com.smart.groovy.XmlUserDao
import org.springframework.core.io.ClassPathResource

beans {
    xmlns context: "http://www.springframework.org/schema/context"    //导入命名空间

    context.'component-scan'('base-package': "com.smart.groovy") {
        'exclude-filter'('type': "aspectj", 'expression': "com.smart.xml.*")
    }

    def stream;
    def config = new Properties();
    try{
        stream = new ClassPathResource('conf/app-conf.properties').inputStream
        config.load(stream);
    }finally {
        if(stream!=null)
        stream.close()
    }

    if( config.get("dataProvider") == "db"){
        userDao(DbUserDao)
    }else{
        userDao(XmlUserDao)
    }

    logDao(LogDao){
        bean->
            bean.scope = "prototype"
            bean.initMethod="init"
            bean.destroyMethod="destory"
            bean.lazyInit =true
    }

    logonService(LogonService,userDao){
        logDao = ref("logDao")
        mailService = ref("mailService")
    }

}