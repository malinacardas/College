using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Windows.Forms;
using System.Configuration;
using System.Collections.Specialized;

namespace HomeworkOne
{
    public partial class Form1 : Form
    {
        SqlConnection dbConn;
        SqlDataAdapter daStadiums;
        SqlDataAdapter daTeams;
        DataSet ds;
        SqlCommandBuilder cb;
        BindingSource bsStadium, bsTeam;

        String pTbl = ConfigurationManager.AppSettings["ParentTable"];
        String cTbl = ConfigurationManager.AppSettings["ChildTable"];



        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            daTeams.Update(ds.Tables[cTbl]);


        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dbConn = new SqlConnection(ConfigurationManager.ConnectionStrings["constr"].ConnectionString);
            ds = new DataSet();

            daStadiums = new SqlDataAdapter(ConfigurationManager.AppSettings["SelectParents"], dbConn);
            daTeams = new SqlDataAdapter(ConfigurationManager.AppSettings["SelectChilds"], dbConn);
            cb = new SqlCommandBuilder(daTeams);


            daStadiums.Fill(ds, pTbl);
            daTeams.Fill(ds, cTbl);

            String constraintName = ConfigurationManager.AppSettings["FKConstraint"];
            String parentPk = ConfigurationManager.AppSettings["FKNameParent"];
            String childPk = ConfigurationManager.AppSettings["FKNameChild"];


            DataRelation dr = new DataRelation(constraintName, ds.Tables[pTbl].Columns[parentPk], ds.Tables[cTbl].Columns[childPk]);
            ds.Relations.Add(dr);

            bsStadium = new BindingSource();
            bsStadium.DataSource = ds;
            bsStadium.DataMember = pTbl;



            bsTeam = new BindingSource();
            bsTeam.DataSource = bsStadium;
            bsTeam.DataMember = constraintName;

            dataGridView1.DataSource = bsStadium;
            dataGridView2.DataSource = bsTeam;




        }
    }
}
