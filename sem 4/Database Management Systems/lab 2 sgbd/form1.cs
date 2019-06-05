using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System;
using System.Data;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;

namespace ShoeDB
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            initialize();
            InitializeComponent();
        }

        SqlConnection dbConn;
        SqlDataAdapter daShoes, daShoeModel;
        DataSet ds;
        SqlCommandBuilder cb;
        BindingSource bsShoes, bsShoeModel;
        private string Connection;
        private string ParentName;
        private string ChildName;
        private string ParentField;
        private string ChildField;

        private void initialize()
        {
            Connection = ConfigurationManager.AppSettings["Connection"];
            ParentName = ConfigurationManager.AppSettings["ParentTable"];
            ChildName = ConfigurationManager.AppSettings["ChildTable"];
            ParentField = ConfigurationManager.AppSettings["ParentField"];
            ChildField = ConfigurationManager.AppSettings["ChildField"];
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dbConn = new SqlConnection(Connection);
            ds = new DataSet();
            daShoes = new SqlDataAdapter("SELECT * FROM " + ParentName,dbConn);
            daShoeModel = new SqlDataAdapter("SELECT * FROM " + ChildName,dbConn);
            SqlCommandBuilder cb = new SqlCommandBuilder(daShoes);
            daShoes.Fill(ds, ParentName);
            daShoeModel.Fill(ds, ChildName);
            ds.Relations.Add("Relation2", ds.Tables[ParentName].Columns[ParentField], ds.Tables[ChildName].Columns[ChildField]);
            bsShoeModel = new BindingSource();
            bsShoeModel.DataSource = ds;
            bsShoeModel.DataMember = ParentName;
            bsShoes = new BindingSource();
            bsShoes.DataSource = bsShoeModel;
            bsShoes.DataMember = "Relation2";
            dataGridView1.DataSource = bsShoeModel;
            dataGridView2.DataSource = bsShoes;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            daShoes.Update(ds, ChildName);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dataGridView1.Refresh();
            dataGridView2.Refresh();
        }
    }
}
