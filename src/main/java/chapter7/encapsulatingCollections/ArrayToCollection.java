package chapter7.encapsulatingCollections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToCollection {

    public Skill[] getSkills() {
        Skill[] result = new Skill[skills.size() - 1];
        System.arraycopy(skills, 0, result, 0, skills.size());
        return result;
    }

    public Skill getSkill(int i) {
        return skills.get(i);
    }

    public void setSkills(Skill[] skills) {
        this.skills = Arrays.asList(skills);
    }

    /* Modifier at particular index */
    public void setSkills(int i, Skill skill) {
        skills.set(i, skill);
    }

    private List<Skill> skills = new ArrayList();

    class Skill{
        private int level;
        Skill(int level) {
            this.level = level;
        }
        public int getLevel() {
            return level;
        }
    }

    @Test
    public void testSettingBasedOnIndex() {
        Skill skill1 = new Skill(1);
        Skill skill2 = new Skill(2);
        Skill[] skills = {skill1, skill2};

        Skill skillNew = new Skill(1);

        ArrayToCollection arrayToCollection = new ArrayToCollection();
        arrayToCollection.setSkills(skills);
        arrayToCollection.setSkills(0, skillNew);

        Skill skill = arrayToCollection.getSkill(0);
        Assert.assertEquals(skill.getLevel(), skillNew.getLevel());
        Assert.assertNotEquals(skill.getLevel(), 10);
    }


}
