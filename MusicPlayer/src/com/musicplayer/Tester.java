package com.musicplayer;

import java.util.*;

public class Tester {

  //Array list of albums
  private static ArrayList<Albums> albums=new ArrayList<>();
    public static void main(String[]args){
        //Create Album
      Albums power=new Albums("Power","Kanye West");
        //Add songs
        power.addSong("Power",4.5);
        power.addSong("Gorgeous",3.5);
        power.addSong("All of the lights",5.5);
        power.addSong("Monster",5.0);
        albums.add(power); //Adds album
        //Create another album
        Albums scorpion=new Albums("Scorpion","Drake");
        //Add songs
        scorpion.addSong("Survival",6.0);
        scorpion.addSong("God's Plan",4.0);
        scorpion.addSong("I'm Upset",6.7);
        scorpion.addSong("Elevate",4.5);
        albums.add(scorpion); //Adds album

        //Creates Playlist
      LinkedList<Songs> playList1=new LinkedList<>();
      //Adds songs to playlist
      albums.get(0).addToPlayList("Power",playList1);
      albums.get(0).addToPlayList("Gorgeous",playList1);
      albums.get(1).addToPlayList("All of the lights",playList1);
      albums.get(1).addToPlayList("Monster",playList1);

      // Method to play the playlist
      play(playList1);

    }

    //Plays the playlist
     private static void play(LinkedList<Songs> playList){
       Scanner in=new Scanner(System.in);
       boolean quit=false;
       boolean forward=true;
       ListIterator<Songs> listIterator= playList.listIterator();

       if(playList.size()==0){ //Checks if playlist is empty or not
         System.out.println("Playlist is empty");
       }else{
         System.out.println("Now playing "+ listIterator.next().toString()); //Plays current song
         Menu();
       }
       while(!quit){ //While the user has not quit
         int action=in.nextInt();
         in.nextLine();

         switch (action){
           case 0: //Quits
             quit=true;
             break;

           case 1: //Plays next song
             if(!forward){
               if(listIterator.hasNext()){
                 listIterator.next();
               }
               forward=true;
             }
             if(listIterator.hasNext()){
               System.out.println("Now playing" + listIterator.next().toString());
             }else{
               System.out.println("No songs available");
               forward=false;
             }
             break;

           case 2: //Plays previous song
             if(forward){
               if(listIterator.hasPrevious()){
                 listIterator.previous();
               }
               forward=false;
             }
              if(listIterator.hasPrevious()){
                System.out.println("Now playing" + listIterator.previous().toString());
              }else{
                System.out.println("No previous songs");
                forward=false;
              }
              break;

           case 3:
             displayList((playList));
             break;

           case 4:
             Menu();
             break;

           case 5:
             if(playList.size()>0){
               listIterator.remove();
               if(listIterator.hasNext()){
                 System.out.println("Now playing" + listIterator.next().toString());
                 forward=true;
               }else{
                 if(listIterator.hasPrevious()){
                   System.out.println("Now playing"+ listIterator.next().toString() );
                 }
               }
             }
         }
       }
     }
     //Menu for available options
    private static void Menu(){
      System.out.println("Options\n Press :");
      System.out.println("0 - To quit");
      System.out.println("1 - To play next song");
      System.out.println("2 - To play previous song");
      System.out.println("3 - To list all songs in the playlist");
      System.out.println("4 - To list available options");
      System.out.println("5 - To delete song");
    }
      //Displays all songs inside the playlist
    private static void displayList(LinkedList<Songs>playList){
      Iterator<Songs> iterator= playList.iterator();
      System.out.println("------------------");

      while(iterator.hasNext()){
        System.out.println(iterator.next());
      }
      System.out.println("------------------");
    }


}
