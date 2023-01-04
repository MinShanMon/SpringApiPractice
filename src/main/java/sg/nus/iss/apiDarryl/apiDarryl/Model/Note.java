package sg.nus.iss.apiDarryl.apiDarryl.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sg.nus.iss.apiDarryl.apiDarryl.util.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "Note")
public class Note extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    @NotEmpty(message = ApplicationConstants.VALIDTION_TITLE_EMPTY)
    @NotBlank(message = ApplicationConstants.VALIDTION_TITLE_EMPTY)
    @Size(max = 50)
    private String title;
    
    @Size(max = 1000)
    private String message;

    @JsonIgnoreProperties(value = {"deleted", "createdBy", "createdTime", "lastUpdateBy", "lastUpdatedTime", "roles"})
    @ManyToOne
    @JoinColumn(name = "id")
    private Member memberDetails;

}
