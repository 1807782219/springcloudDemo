package com.mike.demo.service;

import java.util.List;
import com.mike.demo.entities.Dept;
public interface DeptService {
	public boolean add(Dept dept);
	public Dept    get(Long id);
    public List<Dept> list();

}
