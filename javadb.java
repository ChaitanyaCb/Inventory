import java.sql.*;
import java.util.*;

class javadb
{
	public static void main(String[] args)
	{

		try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
				String s = null;
				Scanner sc = new Scanner(System.in);
				/*PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
				for(int i=1;i<12;i++)
				{
					pstmt.setInt(1,0+i);
					s = ""+(char)(96+i);
					pstmt.setInt(2,12-i);
					pstmt.setString(3,s+"eta");
					pstmt.setInt(4,140+i);
					pstmt.setInt(5,60+i);
					pstmt.setInt(6,10+(i/2));

					pstmt.executeUpdate();
				}
				System.out.println("Inserted");*/
				//Querying database

				System.out.println("Display students in particular class");
				int j=sc.nextInt();
				PreparedStatement query=con.prepareStatement("select name from student where cid=?");
				query.setInt(1,j);
				ResultSet rs = query.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString("name"));
				}

				System.out.println("Reporting teacher for a student:");
				j=sc.nextInt();
				PreparedStatement q = con.prepareStatement("select t.name from class c join teacher t where c.id in (select cid from student where id=?) and c.tid=t.id ");
				q.setInt(1,j);
				rs=q.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString("name"));
				}

				System.out.println("No of Students in a class:");
				j=sc.nextInt();
				q=con.prepareStatement("select count(id) as c from student where cid=?");
				q.setInt(1,j);
				rs=q.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt("c"));
				}


				System.out.println("No of Students under a teacher:");
				j=sc.nextInt();
				q=con.prepareStatement("select count(s.id) as c from student s,class c,teacher t where t.id=? and t.id=c.tid and c.id=s.cid");
				q.setInt(1,j);
				rs=q.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getInt("c"));
				}
				con.close();
		}catch(Exception e){ System.out.println(e);}


	}



}
