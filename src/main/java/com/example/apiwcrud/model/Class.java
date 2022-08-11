package com.example.apiwcrud.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "classe", schema = "apicrud", catalog = "")
public class Class {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotNull
    @Size(min = 5,message = "Điền đúng tên vào")
    private String name;
    @Basic
    @NotNull
    @Size(min = 5,message = "Điền đúng tên lớp vào")
    @Column(name = "room")
    private String room;
    @Basic
    @Column(name = "note")
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return id == aClass.id && Objects.equals(name, aClass.name) && Objects.equals(room, aClass.room) && Objects.equals(note, aClass.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, note);
    }
}
