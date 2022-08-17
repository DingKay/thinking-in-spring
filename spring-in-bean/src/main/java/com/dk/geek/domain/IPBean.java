package com.dk.geek.domain;


/**
 * @author dkay
 * @version 1.0
 */
public class IPBean {
    private String IP;
    private String mac;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "IPBean{" +
                "IP='" + IP + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }

    public static IPBean getIPBean() {
        IPBean ipBean = new IPBean();
        ipBean.setIP("127.0.0.1");
        ipBean.setMac("xcasdasgwg");
        return ipBean;
    }
}
