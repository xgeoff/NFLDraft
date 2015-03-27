/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.digitalindustry.nfl.draft.data;

import biz.digitalindustry.nfl.draft.data.PriorityEntry;
import java.util.List;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author gporemba
 */
@PersistenceCapable
public class DraftPriorities {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public long key;
    public String teamname;
    public String userid;
    public List<PriorityEntry> priorities;
}
