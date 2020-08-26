package com.example.weblog.bean;

public class UserItem {

        /**
         * uid : 1
         * name : test
         * type : 2
         * count : 1
         * email : test@test.com
         * createTime : 2020-07-22 12:12:41
         * updateTime : 2020-08-24 20:39:26
         */

        private int uid;
        private String name;
        private int type;
        private int count;
        private String email;
        private String createTime;
        private String updateTime;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }


}
