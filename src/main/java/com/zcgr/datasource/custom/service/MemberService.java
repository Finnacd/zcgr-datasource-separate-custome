package com.zcgr.datasource.custom.service;

import com.zcgr.datasource.custom.dao.MemberAccountDao;
import com.zcgr.datasource.custom.dao.MemberDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author kevin
 */
@Service
@Transactional
public class MemberService {

    @Resource
    private MemberDao memberDao;

    @Resource
    private MemberAccountDao memberAccountDao;



}
