package com.epam.mjc.io;

import java.io.*;

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
            for (int j = 0; j < result.length(); j++) {
                if(result.contains("Name: "))
                    result = result.replace("Name: ","");
                if(result.contains("Age: "))
                    result = result.replace("Age: ","");
                if(result.contains("Email: "))
                    result = result.replace("Email: ","");
                if(result.contains("Phone: "))
                    result = result.replace("Phone: ","");
            }
            String[] lines = result.split("\\R");
            String name = lines[0];
            String age = lines[1];
            String email = lines[2];
            String phone = lines[3];
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
