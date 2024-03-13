package com.photoalbum.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PhotoMetadata")
public class PhotoMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metadataID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photoID")
    private Photo photo;

    private LocalDateTime captureDate;

    private String location;

    private String cameraType;

    public Long getMetadataID() {
        return metadataID;
    }

    public void setMetadataID(Long metadataID) {
        this.metadataID = metadataID;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public LocalDateTime getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDateTime captureDate) {
        this.captureDate = captureDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String cameraType) {
        this.cameraType = cameraType;
    }
}
