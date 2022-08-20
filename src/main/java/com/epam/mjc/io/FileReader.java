package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String result = "";
        try {
            int i;
            FileInputStream inputStream = new FileInputStream(file.getPath());
            while ((i = inputStream.read()) != -1) {
                result += (char) i;
            }
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.contains("Name: "))
                result = result.replace("Name: ", "");
            if (result.contains("Age: "))
                result = result.replace("Age: ", "");
            if (result.contains("Email: "))
                result = result.replace("Email: ", "");
            if (result.contains("Phone: "))
                result = result.replace("Phone: ", "");
        }
        String[] lines = result.split("\\R");
        profile.setName(lines[0]);
        profile.setAge(Integer.parseInt(lines[1]));
        profile.setEmail(lines[2]);
        profile.setPhone(Long.parseLong(lines[3]));
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
