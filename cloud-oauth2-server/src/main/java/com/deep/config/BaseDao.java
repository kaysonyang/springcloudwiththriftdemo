package com.deep.config;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


public abstract class BaseDao {
	

	/**
     * 创建分页请求.
     */
    public static PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = new Sort(Direction.DESC, "memberId");
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }
}
