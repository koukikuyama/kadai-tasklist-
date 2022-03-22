package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.task;
import util.DBUtil;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public indexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EntityManager em=DBUtil.createEntityManager();
		 List<task>tasks=em.createNamedQuery("getAlltasks",task.class).getResultList();
		 em.close();
		 
		 request.setAttribute("tasks",tasks);
		 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
		 rd.forward(request,response);
		 
	        }


}
