package com.advantest.demeter.service.dto;

import com.advantest.demeter.database.po.TeamPO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record TeamDTO(
        Long id,
        String teamName,
        String description
) {
    public static TeamDTO of(TeamPO teamPO) {
        return new TeamDTO(
                teamPO.getId(),
                teamPO.getTeamName(),
                teamPO.getDescription()
        );
    }
}
