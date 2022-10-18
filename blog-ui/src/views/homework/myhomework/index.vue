<template>
<!--我的作业  -->
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="作业标题" prop="homeworkTitle">
        <el-input
          v-model="queryParams.homeworkTitle"
          placeholder="请输入作业标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-select
          v-model="queryParams.state"
          placeholder="请选择状态"
          clearable
          size="small"
        >
          <el-option
            v-for="dict in dict.type.business_homework_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="StuhomeworkList" @selection-change="handleSelectionChange">
      <el-table-column label="老师姓名" align="center" prop="shomework.teacherName" />
      <el-table-column label="班级名称" align="center" prop="stuClassName"/>
      <el-table-column label="作业标题" align="center" prop="homeworkTitle" />
      <el-table-column label="作业评分" align="center" prop="homeworkScore" />
      <el-table-column label="批阅人" align="center" prop="updateBy" />
      <el-table-column label="批阅时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="state">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.business_homework_status" :value="scope.row.state"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['homework:markstuhomework:edit']"
          >修改</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改查看作业对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生id" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生id" />
        </el-form-item>
        <el-form-item label="学生姓名" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="作业id" prop="homeworkId">
          <el-input v-model="form.homeworkId" placeholder="请输入作业id" />
        </el-form-item>
        <el-form-item label="作业标题" prop="homeworkTitle">
          <el-input v-model="form.homeworkTitle" placeholder="请输入作业标题" />
        </el-form-item>
        <el-form-item label="作业评分" prop="homeworkScore">
          <el-input v-model="form.homeworkScore" placeholder="请输入作业评分" />
        </el-form-item>
        <el-form-item label="评分建议" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入评分建议" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStuhomework, getStuhomework, delStuhomework, addStuhomework, updateStuhomework } from "@/api/homework/Stuhomework";

export default {
  name: "Stuhomework",
  dicts: ['business_homework_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 查看作业表格数据
      StuhomeworkList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        homeworkTitle: null,
        state: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询查看作业列表 */
    getList() {
      this.loading = true;
      listStuhomework(this.queryParams).then(response => {
        this.StuhomeworkList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        studentId: null,
        studentName: null,
        homeworkId: null,
        homeworkTitle: null,
        homeworkContent: null,
        createTime: null,
        updateTime: null,
        homeworkScore: null,
        remark: null,
        createBy: null,
        updateBy: null,
        stuClassName: null,
        state: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加查看作业";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStuhomework(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改查看作业";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStuhomework(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStuhomework(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除查看作业编号为"' + ids + '"的数据项？').then(function() {
        return delStuhomework(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('homework/markstuhomework/export', {
        ...this.queryParams
      }, `Stuhomework_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
