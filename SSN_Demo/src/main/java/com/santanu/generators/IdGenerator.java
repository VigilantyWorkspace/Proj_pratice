package com.santanu.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.SequenceGenerator;

import com.santanu.entity.SsaUserEntity;

/* the condition for setting the ssn
 * 1.has to be unique
   2.has to have 9 digits
   3.has to be int
   4.can not be sequence
 */

public class IdGenerator extends SequenceGenerator
{
    Random r = new Random();
    //private Logger log = LoggerFactory.getLogger(IdGenerator.class);
    Session session;

    int attempt = 0;

    public Long generate9DigitNumber()
    {
        Long aNumber = (long) ((Math.random() * 900000000) + 100000000); 
        return aNumber;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sessionImplementor, Object obj)
    {
        session = (Session) sessionImplementor;
        Long id = generateRandomIndex();
        return id;
    }

    public Long generateRandomIndex()
    {
            for (int i = 0; i < 3; i++)
    {
        //log.info("attempt: " + i);
        Long a = generate9DigitNumber();

        //log.info("index: " + String.valueOf(a));
        if (session.get(SsaUserEntity.class, a) == null)
        {
           // log.info("not found this id");
            return a;
        } else
        {
            //log.info("found this id");
        }
    }

    for (int i = 100000000; i < 999999999; i++)
    {
        //log.info("Is id free: " + i);
        if (session.get(SsaUserEntity.class, i) == null)
        {
            //log.info("id is free: " + i);
            return (long) i;
        }
    }
        return null;
    }
}
