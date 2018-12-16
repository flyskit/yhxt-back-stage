package com.yhxt.java.dao;

import com.yhxt.java.entity.MRSZSR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BudgetEverydayDao
 * @Author zqi
 * @Date 2018/12/16 11:58
 * @Version 1.0
 * @Description
 */
public interface BudgetEverydayDao extends CrudRepository<MRSZSR, String> {
}
