package org.academiadecodigo.tropadelete;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Channel {
    private String name;
    private Set<String> members;

    public void Channel (String name, String member){
        this.name = name;
        members = new HashSet<>();
        members.add(member);
    }

    public void newMemeber (String member){
        members.add(member);
    }

    public void removeMember (String member){
        members.remove(member);
    }

    @Override
    public int hashCode (){
        return name.hashCode();
    }

    @Override
    public boolean equals (Object channel){
        return name.equals(channel);
    }
}
