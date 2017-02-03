<%@page contentType="text/html; charset=GBK"%>
<%@page import="java.security.*,java.net.*,java.io.*"%>
<%!
  public static URL getClassLocation(final Class cls) {
    if (cls == null)throw new IllegalArgumentException("null input: cls");
    URL result = null;
    final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
    final ProtectionDomain pd = cls.getProtectionDomain();
    // java.lang.Class contract does not specify if 'pd' can ever be null;
    // it is not the case for Sun's implementations, but guard against null
    // just in case:
    if (pd != null) {
      final CodeSource cs = pd.getCodeSource();
      // 'cs' can be null depending on the classloader behavior:
      if (cs != null) result = cs.getLocation();
      if (result != null) {
        // Convert a code source location into a full class file location
        // for some common cases:
        if ("file".equals(result.getProtocol())) {
          try {
            if (result.toExternalForm().endsWith(".jar") ||
                result.toExternalForm().endsWith(".zip"))
              result = new URL("jar:".concat(result.toExternalForm())
                               .concat("!/").concat(clsAsResource));
            else if (new File(result.getFile()).isDirectory())
              result = new URL(result, clsAsResource);
          }
          catch (MalformedURLException ignore) {}
        }
      }
    }
    if (result == null) {
      // Try to find 'cls' definition as a resource; this is not
      // document．d to be legal, but Sun's implementations seem to         //allow this:
      final ClassLoader clsLoader = cls.getClassLoader();
      result = clsLoader != null ?
          clsLoader.getResource(clsAsResource) :
          ClassLoader.getSystemResource(clsAsResource);
    }
    return result;
  }
%>
<html>
<head>
<title>srcAdd.jar</title>
</head>
<body bgcolor="#ffffff">
  使用方法，className参数为类的全名，不需要.class后缀，如
  srcAdd.jsp?className=java.net.URL
<%
try
{
  String classLocation = null;
  String error = null;
  String className = request.getParameter("className");

  classLocation =  ""+getClassLocation(Class.forName(className));
  if (error == null) {
    out.print("类" + className + "实例的物理文件位于：");
    out.print("<hr>");
    out.print(classLocation);
  }
  else {
    out.print("类" + className + "没有对应的物理文件。<br>");
    out.print("错误：" + error);
  }
}catch(Exception e)
{
  out.print("异常。"+e.getMessage());
}
%>
</body>
</html>
