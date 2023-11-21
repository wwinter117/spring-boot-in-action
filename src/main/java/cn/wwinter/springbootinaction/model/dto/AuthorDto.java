package cn.wwinter.springbootinaction.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: BookDto
 * Package: cn.wwinter.springbootinaction.database.domain.dto
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private Integer age;
}
