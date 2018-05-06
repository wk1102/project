package ssm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Test {
	public static void  main(String[] args){
		//1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory =  new IniSecurityManagerFactory("classpath:shiro.ini");
		//2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
	    //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
	    subject.login(token);
	    
	}
}
