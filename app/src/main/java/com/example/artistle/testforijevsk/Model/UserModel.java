package com.example.artistle.testforijevsk.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserModel {


    public class Example {

        @SerializedName("response")
        @Expose
        private List<Response> response = null;

        public List<Response> getResponse() {
            return response;
        }

        public void setResponse(List<Response> response) {
            this.response = response;
        }

    }

    public class Response {

        @SerializedName("f_name")
        @Expose
        private String fName;
        @SerializedName("l_name")
        @Expose
        private String lName;
        @SerializedName("birthday")
        @Expose
        private String birthday;
        @SerializedName("avatr_url")
        @Expose
        private String avatrUrl;
        @SerializedName("specialty")
        @Expose
        private List<Specialty> specialty = null;

        public String getFName() {
            return fName;
        }

        public void setFName(String fName) {
            this.fName = fName;
        }

        public String getLName() {
            return lName;
        }

        public void setLName(String lName) {
            this.lName = lName;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAvatrUrl() {
            return avatrUrl;
        }

        public void setAvatrUrl(String avatrUrl) {
            this.avatrUrl = avatrUrl;
        }

        public List<Specialty> getSpecialty() {
            return specialty;
        }

        public void setSpecialty(List<Specialty> specialty) {
            this.specialty = specialty;
        }

    }

    public class Specialty {

        @SerializedName("specialty_id")
        @Expose
        private int specialtyId;
        @SerializedName("name")
        @Expose
        private String name;

        public int getSpecialtyId() {
            return specialtyId;
        }

        public void setSpecialtyId(int specialtyId) {
            this.specialtyId = specialtyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}





