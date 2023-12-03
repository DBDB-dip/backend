package dbdip.demo.expert.dto;

import dbdip.demo.expert.entity.WorkAt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkAtDto {
    @Schema(description = "expertsId")
    private Integer expertsId;
    @Schema(description = "work day")
    private String workDay;
    @Schema(description = "start time")
    private Integer startTime;
    @Schema(description = "end time")
    private Integer endTime;

    public WorkAtDto(WorkAt workAt){
        this.expertsId = workAt.getExpert().getId();
        this.workDay = workAt.getId().getWorkDay();
        this.startTime = workAt.getStartTime();
        this.endTime = workAt.getEndTime();
    }
}
