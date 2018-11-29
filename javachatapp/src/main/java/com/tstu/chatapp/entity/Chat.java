package com.tstu.chatapp.entity;

import com.tstu.chatapp.enums.ChatStatus;
import com.tstu.chatapp.enums.ChatType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_chat")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", columnDefinition = "int2")
    private ChatType type;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", columnDefinition = "int2")
    private ChatStatus status;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "closed_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", columnDefinition = "int4")
    private User user;
}
