package edu.odeyalo.college.coursework.service.authentication;

import edu.odeyalo.college.coursework.entity.Commandant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandantAuthenticationResult {
    private String authenticationType;
    private Commandant commandant;
    private Object body;

    public static final String JWT = "jwt";
    public static final String SESSION = "session";
}
