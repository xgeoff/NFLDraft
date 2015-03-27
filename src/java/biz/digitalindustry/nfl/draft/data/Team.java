/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.digitalindustry.nfl.draft.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author gporemba
 */
@PersistenceCapable
public class Team {
    @PrimaryKey
    public String name;
    public String city;
    public String nickname;
    public String abbrev;
}
