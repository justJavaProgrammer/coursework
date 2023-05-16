package edu.odeyalo.college.coursework.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.odeyalo.college.coursework.entity.Faculty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultySavedDto {
    @JsonProperty("is_saved")
    private boolean isSaved;
    @JsonProperty("faculty")
    private Faculty faculty;

    public static FacultySavedDto saved(Faculty faculty) {
        return new FacultySavedDto(true, faculty);
    }

    public static FacultySavedDto failed() {
        return new FacultySavedDto(false, null);
    }

}
