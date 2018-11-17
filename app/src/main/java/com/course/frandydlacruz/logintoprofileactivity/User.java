package com.course.frandydlacruz.logintoprofileactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String password;
    private int photoPath;
    private String description;
    private int repoCount;
    private int commitsCount;
    private int starsCount;

    public User(String name, String password, int photoPath, String description, int repoCount, int commitsCount, int starsCount) {
        this.name = name;
        this.password = password;
        this.photoPath = photoPath;
        this.description = description;
        this.repoCount = repoCount;
        this.commitsCount = commitsCount;
        this.starsCount = starsCount;
    }

    protected User(Parcel in) {
        name = in.readString();
        password = in.readString();
        photoPath = in.readInt();
        description = in.readString();
        repoCount = in.readInt();
        commitsCount = in.readInt();
        starsCount = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(int photoPath) {
        this.photoPath = photoPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRepoCount() {
        return repoCount;
    }

    public void setRepoCount(int repoCount) {
        this.repoCount = repoCount;
    }

    public int getCommitsCount() {
        return commitsCount;
    }

    public void setCommitsCount(int commitsCount) {
        this.commitsCount = commitsCount;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
        dest.writeInt(photoPath);
        dest.writeString(description);
        dest.writeInt(repoCount);
        dest.writeInt(commitsCount);
        dest.writeInt(starsCount);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
