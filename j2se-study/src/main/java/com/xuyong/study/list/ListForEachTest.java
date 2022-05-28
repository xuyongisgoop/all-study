package com.xuyong.study.list;

import java.util.List;

/**
 * Created by xuyong on 2022/2/13
 */
public class ListForEachTest {

    public static void main(String[] args) {
        Rote rote = new Rote();
        for (Integer item : rote.getRoteList()) {

        }
    }

    public static class Rote {
        private List<Integer> roteList;

        public List<Integer> getRoteList() {
            return roteList;
        }

        public void setRoteList(List<Integer> roteList) {
            this.roteList = roteList;
        }
    }

}
