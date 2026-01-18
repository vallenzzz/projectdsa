/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fypstacklinkedlist;

/**
 *
 * @author User
 */
public class Node {
     int week;
     String starttime;
     String endtime;
     String discussiondetails;
     String platformused;
     String svfeedback;
    Node ptrnext;
    
    public Node (int week, String starttime, String endtime, String discussiondetails, String platformused, String svfeedback){
    this.week = week;
    this.starttime = starttime;
    this.endtime = endtime;
    this.discussiondetails = discussiondetails;
    this.platformused = platformused;
    this.svfeedback = svfeedback;
    this.ptrnext = null;
    }
}
