/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.digitalindustry.nfl.draft.data;

import java.util.List;
import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author gporemba
 */
@PersistenceCapable
public class PositionRank {
    public String player;
    public String position;
    public int rank;
    
}
