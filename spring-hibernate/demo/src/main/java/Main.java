import com.springhibernate.demo.entity.DepartmentEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }

//        String hql = "select p from DepartmentEntity p where p.id = ?";
//        Query query = getSession().createQuery(hql).setInteger(0, 1);
//        DepartmentEntity departmentEntity = (DepartmentEntity) query.uniqueResult();
//        System.out.println(departmentEntity);

        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);
    }
}
