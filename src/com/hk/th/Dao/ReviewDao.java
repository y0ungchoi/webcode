package com.hk.th.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.hk.th.vo.EmpVo;
import com.hk.th.vo.Review_contentVo;
import com.hk.th.vo.Review_prod_reportVo;
import com.hk.th.vo.Review_reportVo;

public class ReviewDao {
	
	static String url="jdbc:mysql://localhost:3306/momasil";
	static String user="root";
	static String password="mysql";
	static Connection conn; 
	static PreparedStatement pstmt; 
	static ResultSet rs;


	public void getconnectDB() {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,user,password);
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
	public void DBClose() {
        if(conn!=null) { try {conn.close(); conn=null;} catch (SQLException e) {} }
        if(pstmt!=null) { try {pstmt.close(); pstmt=null;} catch (SQLException e) {} }
        if(rs!=null) { try {rs.close(); rs=null;} catch (SQLException e) {} }
	}
	
	
//	신고 보내기
	public int rev_report(Review_reportVo rr) {
		int rst = 0;
		getconnectDB();
		String sql = "insert into rev_report(rr_no, rev_no, mid, rr_date, rr_content) "
				+ "values(?,?,?,now(),?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rr.getRr_no());
			pstmt.setInt(2, rr.getRev_no());
			pstmt.setString(3, rr.getMid());
			pstmt.setString(4, rr.getRr_content());
			
			rst = pstmt.executeUpdate();
			System.out.println("rev_report 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBClose();
		return rst;
	}
	
//  제품정보수정 등록
	public int prod_report(Review_prod_reportVo rpvo) {
		int rst = 0;
		getconnectDB();
		String sql = "insert into prod_report(pr_no, prod_no, mid, pr_date, pr_content) "
				+ "values(?,?,?,now(),?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rpvo.getPr_no());
			pstmt.setInt(2, rpvo.getProd_no());
			pstmt.setString(3, rpvo.getMid());
			pstmt.setString(4, rpvo.getPr_content());
			
			rst = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBClose();
		return rst;
	}
	
//	리뷰 등록
	public int rev_content(Review_contentVo rc) {
		int rst = 0;
		getconnectDB();
		String sql = "insert into review (rev_no, prod_no, mid, rev_content, rev_date, prod_rating, rev_rating, rev_photo) "
				+ "values(null,?,?,?,now(),?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rc.getProd_no());
			pstmt.setString(2, rc.getMid());
			pstmt.setString(3, rc.getRev_content());
			pstmt.setInt(4, rc.getProd_rating());
			pstmt.setInt(5, rc.getRev_rating());
			pstmt.setString(6, rc.getRev_photo());
			
			rst = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBClose();
		return rst;
	}
	
//	리뷰 글 목록
	public Vector<Review_contentVo> SelectReview(String cnt,int prod) {
		Vector<Review_contentVo> rst = new Vector<Review_contentVo>();
		getconnectDB();
		
		String str ="";
		if(prod != 10) {
			str = "where prod_rating = '" + prod + "'";
		}
		
		String sql = "select * from review " + str + "order by rev_no desc limit ?,5";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cnt));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review_contentVo temp = new Review_contentVo();
				temp.setRev_no(rs.getInt(1));
				temp.setProd_no(rs.getInt(2));
				temp.setMid(rs.getString(3));
				temp.setRev_content(rs.getString(4));
				temp.setRev_date(rs.getString(5));
				temp.setProd_rating(rs.getInt(6));
				temp.setRev_rating(rs.getInt(7));
				temp.setRev_photo(rs.getString(8));
				
				rst.add(temp);
			}
			System.out.println("SelectReview 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBClose();
		return rst;
	}
	
//	리뷰평점 필터기능
	public Vector<Review_contentVo> SelectReviewfilter(int num) {
		Vector<Review_contentVo> rst = new Vector<Review_contentVo>();
		getconnectDB();
		
		String str = "";
		if(num != 10) {
			str = " where prod_rating = '" + num + "'";
		}
		
		String sql = "select * from review" + str + " order by rev_date desc limit 5";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review_contentVo temp = new Review_contentVo();
				temp.setRev_no(rs.getInt(1));
				temp.setProd_no(rs.getInt(2));
				temp.setMid(rs.getString(3));
				temp.setRev_content(rs.getString(4));
				temp.setRev_date(rs.getString(5));
				temp.setProd_rating(rs.getInt(6));
				temp.setRev_rating(rs.getInt(7));
				temp.setRev_photo(rs.getString(8));
				
				rst.add(temp);
			}
			System.out.println("SelectReview 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBClose();
		return rst;
	}
	
	
//	리뷰 조건별 개수
	public int selectCount(int num) {
		int rst = 0;
		getconnectDB();
		String sql = "";
		switch(num){
		case 1:
			sql = "select count(*) from review ";
			break;
		case 2:
			 sql = "select count(*) from review where prod_rating = 5";
			break;
		case 3:
			 sql = "select count(*) from review where prod_rating = 3";
			break;
		case 4:
			 sql = "select count(*) from review where prod_rating = 1";
			break;
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rst = rs.getInt(1);
			}
			System.out.println(" selectCount 쿼리성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBClose();
		return rst;
	}
	
	
// 리뷰평점 평균
	public int selectavg() {
		int rst = 0;
		getconnectDB();
		String sql ="select avg(prod_rating) from review"; /*조건에 제품번호 넣어야됨*/
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rst = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBClose();
		return rst;
	}
// 메인페이지 랭킹	
	public ArrayList mainrank() {
		ArrayList rst = new ArrayList();
		getconnectDB();
		String sql = "SELECT id, name, salary, designation FROM TBLEMP";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpVo temp = new EmpVo();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
				temp.setSalary(rs.getInt("salary"));
				temp.setDesignation(rs.getString("designation"));
				rst.add(temp);
			}
			System.out.println("selectEmp 쿼리성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBClose();
		return rst;
	}
	

// 리뷰삭제
	public int rev_delete(int rev_no) {
		int rst = 0;
		getconnectDB();
		String sql = "delete from review where rev_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rev_no);
			
			rst = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBClose();
		return rst;
	}
	
// 업데이트 
		public int rev_update(Review_contentVo rcvo) {
			int rst = 0;
			getconnectDB();
			String sql = "update review set prod_rating=?, rev_content=? where rev_no=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rcvo.getProd_rating());
				pstmt.setString(2, rcvo.getRev_content());
				pstmt.setInt(3, rcvo.getRev_no());
				
				rst = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBClose();
			return rst;
		}

// 좋아요 기능 
		public int like(int rev_no) {
			int rst = 0;
			getconnectDB();
			String sql = "update review set rev_rating = rev_rating +1 where rev_no=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rev_no);
				
				rst = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBClose();
			return rst;
		}
		
// 좋아요한사람 추가
		public int like2(String likeid, int rev_no) {
			int rst = 0;
			getconnectDB();
			String sql = "insert into likey values(?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, likeid);
				pstmt.setInt(2, rev_no);

				rst = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBClose();
			return rst;
		}

				
}
