package cn.wwinter.springbootinaction.database.domain.dto;

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
public class BookDto {
    private String isbn;
    private String title;
    private String author;
}
