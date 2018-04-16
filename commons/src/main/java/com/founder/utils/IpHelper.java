package com.founder.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.*;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-11-30 14:22
 **/
public class IpHelper {

    /**
     * 获取访问客户端Ip
     */
    public static String getIp(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                int index = ip.indexOf(",");
                if (index != -1) {
                    return ip.substring(0, index);
                } else {
                    return ip;
                }
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getHeader("Proxy-Client-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip != null) {
            if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        ip = request.getRemoteAddr();
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 获取客户端物理地址
     *
     * @param sip
     * @return
     */
    public static String getMac(String sip) {
        String smac = "";
        ExecutorService exec = Executors.newFixedThreadPool(1);
        try {
            final UdpGetClientMacAddr umac = new UdpGetClientMacAddr(sip);
            //---长时间获取不到MAC地址则放弃

            Callable<String> call = new Callable<String>() {
                public String call() throws Exception {
                    return umac.GetRemoteMacAddr();
                }
            };
            Future<String> future = exec.submit(call);
            smac = future.get(1000 * 1, TimeUnit.MILLISECONDS);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // 关闭线程池
            exec.shutdown();
        }
        return smac;
    }

    /**
     * 获取项目根目录, ip:port/项目名,后面手动拼控制器地址,从ctrl的@RequestMapping开始,再到方法
     * eg response.sendRedirect((new StringBuilder()).append(getRoot(request)).append("login").toString());
     */
    private static String getRoot(HttpServletRequest request) {
        StringBuilder sbRoot = new StringBuilder(50);
        sbRoot.append("http://").append(request.getServerName()).append(":")
                .append(request.getServerPort());
        String strContextPath = request.getContextPath();
        if (strContextPath != null && !strContextPath.equals("/")) {
            sbRoot.append(strContextPath);
        }
        sbRoot.append("/");
        return sbRoot.toString();
    }
}
