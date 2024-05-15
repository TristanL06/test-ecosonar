package com.afklm.greenrulestesting;

import com.afklm.greenrulestesting.model.Aircraft;
import com.afklm.greenrulestesting.repository.AircraftRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class FirstHelper {

    private final List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L, 5L);
    private final List<Aircraft> a = new ArrayList<>();
    private final AircraftRepository aircraftRepository;
    private Connection conn;

    public FirstHelper(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
        a.add(new Aircraft());
    }

    /**
     * Raised
     */
    //Not compliant
    public static final List<String> ec76_list = new ArrayList<>();
    public static final Set<String> ec76_let = new HashSet<>();
    public static final Map<Integer, String> ec76_map = new HashMap<>();

    /**
     * Raised
     */
    public void ec3(){
        List<String> list = new ArrayList<>();
        list.add("A");
        for(int i = 0; i < list.size(); ++i){
            System.out.println("Element " + i);
        }
    }

    /**
     * Raised
     */
    public void ec2(){
        int index = 1;
        int nb = 2;

        if (nb > index) {
            nb = nb + index;
        } else {
            nb = nb - 1;
        }
        if (nb != index + 1) {
            nb = nb + index;
        } else {
            nb = nb - 1;
        }
    }

    /**
     * Raised
     */
    public void ec1(){
        List<Aircraft> aircrafts = new ArrayList<>();

        for(Long id : ids){
            aircrafts.add(aircraftRepository.findById(id).orElse(null));
        }
    }

    /**
     * Raised
     */
    public void ec72() throws SQLException {
        String baseQuery = "SELECT id, aircraft_name FROM aircraft WHERE id = ";
        for(int i=0;  i<5; ++i){
            String query = baseQuery.concat(""+i);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("aircraft_name");
                System.out.println(name);
            }
            st.close();
        }
    }

    /**
     * Raised
     */
    public boolean ec77() {
        final Pattern pattern = Pattern.compile("foo");
        return pattern.matcher("foo").find();
    }

    /**
     * Raised
     */
    public void ec69() {
        for (int i = 0; i < getMyValue(); ++i) {
            System.out.println(i);
            boolean b = getMyValue() > 6;
        }
    }

    public int getMyValue() {
        return 5;
    }

    /**
     * Raised
     */
    public void ec78() throws SQLException {
        String query = "insert into aircraft (id, aircraft_type, aircraft_name) values(?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        for(Aircraft o : a) {
            stmt.setInt(1, 123);
            stmt.setString(2, o.getAircraftType());
            stmt.setString(3, o.getAircraftName());
            stmt.addBatch();
        }
    }

    /**
     * Raised
     */
    public void ec74(){
        String baseQuery = "SELECT * FROM aircraft";
    }

    /**
     * Not raised
     */
    private static void ec79() throws IOException {
        FileInputStream input = new FileInputStream("file.txt");
        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
    }

    /**
     * Raised
     */
    public void ec32(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; ++i) {
            sb.append("A");
        }
    }

    /**
     * Raised
     */
    public void ec28() throws IOException {
        String filename = "test.txt";
        InputStream in = null;
        try {
            in = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        in.read();
    }

    /**
     * Raised
     */
    public int ec67(int id){
        return id++;
    }

    /**
     * Raised
     */
    public void ec5() throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO aircraft(id, aircraft_name) VALUES(2, 'A320')");
    }

    /**
     * Raised
     */
    public boolean[] ec27(){
        boolean[] array = new boolean[10];
        int len = array.length;
        boolean[] copy = new boolean[array.length];
        for (int i = 0; i < len; ++i) {
            copy[i] = array[i];
        }
        return copy;
    }

    /**
     * Raised
     */
    public void s1643(){
        String[] arrayOfStrings = new String[100];
        String str = "";
        for (int i = 0; i < arrayOfStrings.length ; ++i) {
            str = str + arrayOfStrings[i];
        }
    }


    public String ec75(String[] strings) {
        String result = "";

        for (String string : strings) {
            result += string; // Noncompliant
        }

        for (int i = 0; i < 1000; ++i) {
            result += "another"; // Noncompliant
        }
        return result;
    }
}