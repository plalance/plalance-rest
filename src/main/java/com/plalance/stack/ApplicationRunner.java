package com.plalance.stack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.plalance.configuration.SpringConfig;

/**
 * Provide environnement to run a Main class, initialize spring context, etc.. and execute the <tt>run</tt> method.
 * <br/>
 * Extends this class. In the main method call initialize(xx.class, args).
 */
public abstract class ApplicationRunner
{
	/**
	 * Initialize runner and run it
	 *
	 * @param runable
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static <R extends ApplicationRunner> void initialize(Class<R> runable, String... args)
	{
		// Initialize application
		// ------------------------------------
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		ApplicationRunner app = context.getBean(runable);

		// Run
		// ------------------------------------
		Long startTime = System.currentTimeMillis();
		try
		{
			app.beforeRun();
			app.run();
			app.afterRun();
		}
		catch (Exception e)
		{
			System.out.println("> [ KO ] F.A.I.L.");
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			Long elapseTime = System.currentTimeMillis() - startTime;
			System.out.println(String.format("> [ DONE ] Time elapse : %02dh %02dm %02ds %02dms", //
					(elapseTime / (1000 * 60 * 60)) % 24, //
					(elapseTime / (1000 * 60)) % 60, //
					(elapseTime / 1000) % 60, //
					elapseTime % 1000));

			System.out.println("exit");
			System.exit(0);
		}
	}

	/**
	 * Do things before run.
	 */
	public void beforeRun()
	{
	}

	/**
	 * Do things after run.
	 */
	public void afterRun()
	{
	}

	/**
	 * Run
	 *
	 * @throws TechnicalException
	 */
	public abstract void run();

}
