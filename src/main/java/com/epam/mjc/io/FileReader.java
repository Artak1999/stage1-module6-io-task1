package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;

public class FileReader {

    public Profile getDataFromFile(File file){
        Profile profile = new Profile();
        try {
            int i;
            String result = "";
            FileInputStream inputStream = new FileInputStream(file.getPath());
            while((i = inputStream.read()) != -1) {
                result += (char) i;
            }
            System.out.println(result);
            String[] lines = result.split("\\R");
            String name = lines[0];
            String age = lines[1];
            String email = lines[2];
            String phone = lines[3];
            for (int j = 0; j < name.length(); j++) {
                if(name.contains("Name: "))
                    name = name.replace("Name: ","");
            }
            for (int j = 0; j < age.length(); j++) {
                if(age.contains("Age: "))
                    age = age.replace("Age: ","");
            }
            for (int j = 0; j < email.length(); j++) {
                if(email.contains("Email: "))
                    email = email.replace("Email: ","");
            }
            for (int j = 0; j < phone.length(); j++) {
                if(phone.contains("Phone: "))
                    phone = phone.replace("Phone: ","");
            }
            profile.setName(name);
            profile.setAge(Integer.parseInt(age));
            profile.setEmail(email);
            profile.setPhone(Long.parseLong(phone));
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
