package com.application.chat.myapplication.model;

/**
 * Created by vaibhav on 11/2/18.
 */

public class User
{

    String id;
    String n;
    String l;
    String a;
    String d;
    String s;
    String m;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getLstn() {
        return lstn;
    }

    public void setLstn(String lstn) {
        this.lstn = lstn;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getRdrs() {
        return rdrs;
    }

    public void setRdrs(String rdrs) {
        this.rdrs = rdrs;
    }

    String g;
    String ls;
    String lstn;
    String ch;
    String rdrs;



   /* In subscribe success response {"_119":{"id":"119","n":"8","l":"\/\/.chatforyoursite.com119","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1517905187","lstn":"0","ch":"172a11d52ca4dabd5f026748954db909","rdrs":"1"},"_120":{"id":"120","n":"9","l":"\/\/.chatforyoursite.com120","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1517829411","lstn":"0","ch":"3b41a1e28e447e231efef6ca5a49cdaf","rdrs":"1"},"_123":{"id":"123","n":"Demo 2","l":"\/\/.chatforyoursite.com123","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1518153111","lstn":"0","ch":"650a7052a96a598bf3a44c06b45a99c6","rdrs":"1"},"_124":{"id":"124","n":"Demo 4","l":"\/\/.chatforyoursite.com124","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1518153397","lstn":"0","ch":"cf00c601ec8b7bd088654d73e1a921a7","rdrs":"1"},"_113":{"id":"113","n":"demo222","l":"\/\/.chatforyoursite.com113","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1516260084","lstn":"0","ch":"e73c60619b1f6b4ab58adfba01f72aee","rdrs":"1"},"_118":{"id":"118","n":"demo30","l":"\/\/.chatforyoursite.com118","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"available","m":"I'm available","g":"","ls":"1515070140","lstn":"0","ch":"043702631ac746861abd9deebfc0d0dd","rdrs":"1"},"_126":{"id":"126","n":"Demo 7","l":"\/\/.chatforyoursite.com126","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"1","s":"away","m":"I'm away","g":"","ls":"1518103957","lstn":"0","ch":"8a7ab520f803961ec647b0baaaf90095","rdrs":"1"},"_37":{"id":"37","n":"1","l":"\/\/.chatforyoursite.com37","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"2d00e4c2df9749dd6479fe8dfa5564bc","rdrs":1},"_79":{"id":"79","n":"100","l":"\/\/.chatforyoursite.com79","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"951ed16bd909e967eb3841959d503e1b","rdrs":1},"_82":{"id":"82","n":"101","l":"\/\/.chatforyoursite.com82","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"c5733d1eba6fefa6e114d0628cf16f0c","rdrs":1},"_47":{"id":"47","n":"12","l":"\/\/.chatforyoursite.com47","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"df86c6f35163607f2b20b947ae530a94","rdrs":1},"_48":{"id":"48","n":"12","l":"\/\/.chatforyoursite.com48","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"1a8da449420153bfd942952a97106a34","rdrs":1},"_14":{"id":"14","n":"2","l":"\/\/.chatforyoursite.com14","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"3624e4c26883f25d69c61c3771f26934","rdrs":1},"_80":{"id":"80","n":"200","l":"\/\/.chatforyoursite.com80","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"d0292a4ab8b09478c872ff1a3692fa60","rdrs":1},"_73":{"id":"73","n":"3","l":"\/\/.chatforyoursite.com73","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"0a9e058a0f546f90826010e2ad5f800f","rdrs":1},"_115":{"id":"115","n":"3","l":"\/\/.chatforyoursite.com115","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m":"I'm offline","g":"","ls":"","lstn":"","ch":"885972a42ab62980aefb5e7b1ef8eddc","rdrs":1},"_117":{"id":"117","n":"30","l":"\/\/.chatforyoursite.com117","a":"\/\/fast.cometondemand.net\/admin\/images\/pixel.png","d":"0","s":"offline","m"*/


/*   "id" : "5",
           "n" : "MyName",
           "l" : "link",
           "a" : "avatar.png",
           "s" : "available",
           "m" : "I'm available",
           "push_channel" : "C_e9d4eb1e42bc17d6540e46a72af90c81",
           "push_an_channel" : "ANN_1c361dfb0ac82a9f988ed4c1f4bcb785"*/


    public String getId()
    {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }


}
