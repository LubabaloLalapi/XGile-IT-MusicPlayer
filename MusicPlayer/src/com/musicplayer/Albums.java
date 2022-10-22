package com.musicplayer;

import java.util.*;

public class Albums {
    String name;
    String artist;
    ArrayList<Songs> songs;

    public Albums(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Songs>();
    }


    public Albums(){

    }

    //Checks for the song
    public Songs checkSong(String title){
        for(Songs checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
        //Add songs inside the album
    public boolean addSong(String title,double duration){
        if(checkSong(title)==null){  //If there is no song, then add song
            songs.add(new Songs(title,duration));
            System.out.println(title + "successfully added to the list");
            return true;
        }
        else{
            System.out.println("Song" + title + "already exists");
        }
        return false;
    }

    //Add songs to playlist using track number
    public boolean addToPlaylist(int trackNumber, Set<Songs> PlayList){
        int index=trackNumber-1;
        if(index >0 && index<= this.songs.size()){ //Checks song if it is added to the playlist
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have the song with the track number"+ trackNumber);
        return false;
    }

    //Add songs to playlist using title of the song
    public boolean addToPlayList(String title, LinkedList<Songs> PlayList){
        for(Songs checkedSong: this.songs){ //Checks song if it is added to the playlist
            if(checkedSong.getTitle().equals(title)){
                return true;
            }
        }
        System.out.println("There is no such song in the album");
        return false;
    }


}
