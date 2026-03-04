package com.academy.four.dao.player;

import com.academy.four.dao.Dao;

import java.util.List;

public class PlayerInfoDao implements Dao<PlayerInfo> {
    @Override
    public boolean save(PlayerInfo entity) {
        return false;
    }

    @Override
    public boolean update(PlayerInfo entity) {
        return false;
    }

    @Override
    public boolean delete(PlayerInfo entity) {
        return false;
    }

    @Override
    public PlayerInfo findById(Integer id) {
        return null;
    }

    @Override
    public List<PlayerInfo> findAll() {
        return List.of();
    }
}
