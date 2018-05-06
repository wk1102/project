package com.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ����쳣��
 * @author wk
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {

		//handler���Ǵ�����������Ҫִ�е�Handler����(ֻ��method)  
        //�������쳣���͡�  
          
        //����� �쳣������ϵͳ �Զ�����쳣��ֱ��ȡ���쳣��Ϣ���ڴ���ҳ��չʾ��  
        CustomException customException=null;  
        if(ex instanceof CustomException){  
            customException=(CustomException)ex;  
              
        }else{  
            //����� �쳣���Ͳ���ϵͳ �Զ�����쳣������һ���Զ�����쳣���ͣ���ϢΪ��δ֪���󡱣���  
            customException=new CustomException(ex.getMessage());  
        }  
        //������Ϣ  
        String message=customException.getMessage();  
          
        ModelAndView modelAndView=new ModelAndView();  
          
        //��������Ϣ����ҳ��  
        modelAndView.addObject("message",message);  
          
        //ָ�򵽴������  
        modelAndView.setViewName("error");  
          
        return modelAndView;  
	}

}
