package com.advantest.demeter.service.impl;

import com.advantest.demeter.database.po.TeamPO;
import com.advantest.demeter.database.mapper.TeamMapper;
import com.advantest.demeter.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, TeamPO> implements TeamService {
}
