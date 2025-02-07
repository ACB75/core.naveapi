package com.w2m.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import com.w2m.entity.NaveEspacial;
import com.w2m.repository.NaveEspacialRepository;

public abstract class NaveEspacialRepositoryImpl implements NaveEspacialRepository {

    //private static final const SELECT = "SELECT ";
    private Connection connection;

    public NaveEspacialRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<NaveEspacial> findByNameContaining(String name) {
        List<NaveEspacial> entityList = new ArrayList<>();
        String sql = "SELECT * FROM nave_espacial WHERE name LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NaveEspacial entity = new NaveEspacial();
                entity.setId(rs.getInt("id"));
                entity.setName(rs.getString("name"));
                // Set other fields as needed
                entity.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
