package com.smart.groovy;


public class LogonService {

    private UserDao userDao;
    private LogDao logDao;
    private MailService mailService;

    public LogonService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public MailService getMailService() {
        return mailService;
    }
}
