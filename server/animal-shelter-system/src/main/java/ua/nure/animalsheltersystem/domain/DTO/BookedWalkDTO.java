package ua.nure.animalsheltersystem.domain.DTO;

import java.time.LocalDate;

public class BookedWalk {
    private Long idUser;
    private Long idAnimal;
    private LocalDate date_of_walk;
    private int duration;
    public BookedWalk(Long idUser, Long idAnimal, LocalDate date_of_walk, int duration) {
        this.idUser = idUser;
        this.idAnimal = idAnimal;
        this.date_of_walk = date_of_walk;
        this.duration = duration;
    }
    public BookedWalk() {}

    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public Long getIdAnimal() {
        return idAnimal;
    }
    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
    public LocalDate getDate_of_walk() {
        return date_of_walk;
    }
    public void setDate_of_walk(LocalDate date_of_walk) {
        this.date_of_walk = date_of_walk;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "BookedWalk{" +
                "idUser=" + idUser +
                ", idAnimal=" + idAnimal +
                ", dateOfWalk=" + date_of_walk +
                ", duration=" + duration +
                '}';
    }
}
