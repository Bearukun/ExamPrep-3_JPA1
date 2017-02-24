package facade;

import entity.Project;
import entity.ProjectUser;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade {

    private EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {

        Facade fc = new Facade();

        fc.initiateSystem();

        //Create some users
        fc.createUser("Bob", "bob@microsoft.com", "1 January 2017");
        fc.createUser("Linda", "linda@microsoft.com", "24 Feburary 2017");

        //Find user with ID 0
        fc.finduser(1);

        //Get all users
        fc.getAllUsers();
        
        //Create project
        fc.createProject("Argo", "Secret stuff", "22 December 2016", "20 Feburary 2017");
        
        //Assign projectUser to project
        fc.assignToProject(1, 1);

        //Close entityManager
        fc.closeSystem();

    }

    public void initiateSystem() {

        Persistence.generateSchema("pu", null);

        emf = Persistence.createEntityManagerFactory("pu");

        em = emf.createEntityManager();

    }

    public void closeSystem() {

        em.close();

    }

    public void createUser(String username, String email, String creationDate) {

        em.getTransaction().begin();

        em.persist(new ProjectUser(username, email, creationDate));

        em.getTransaction().commit();

    }

    public void finduser(int id) {

        System.out.println(em.find(ProjectUser.class, id).toString());

    }

    public void getAllUsers() {

        List<ProjectUser> pU = new ArrayList();

        pU = em.createNamedQuery("Projectuser.findAll").getResultList();

        for (ProjectUser projectUser : pU) {

            System.out.println(projectUser.toString());

        }

    }

    public void createProject(String name, String description, String created, String lastModified) {

        em.getTransaction().begin();

        em.persist(new Project(name, description, created, lastModified));

        em.getTransaction().commit();

    }
    
    public void assignToProject(int projectUserId, int projectId){

        em.getTransaction().begin();
        
        ProjectUser pU = em.find(ProjectUser.class, projectUserId);
        Project pj = em.find(Project.class, projectId);
        
        pj.addContributor(pU);
        
        em.persist(pj);
        em.getTransaction().commit();
        
    }

}
