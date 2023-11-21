package cn.wwinter.springbootinaction.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: BookDto
 * Package: cn.wwinter.springbootinaction.database.domain
 * Description:
 * Datetime: 2023/11/13
 * AuthorEntity: zhangdd
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_books")
public class BookEntity {
    @Id
    private String isbn;

    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

}
