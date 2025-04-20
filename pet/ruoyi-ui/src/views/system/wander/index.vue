<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="当前状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择当前处理状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_pet_wander"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="发现地" prop="discoveryLocation">
        <el-input
          v-model="queryParams.discoveryLocation"
          placeholder="请输入发现地点的详细文字描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="关联宠物信息的宠物id" prop="petId">
        <el-input
          v-model="queryParams.petId"
          placeholder="请输入关联宠物信息的宠物id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="上报时间" prop="reportTime">
        <el-date-picker clearable
          v-model="queryParams.reportTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择上报时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:wander:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:wander:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:wander:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:wander:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="wanderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="流浪动物唯一标识ID" align="center" prop="wanderId" /> -->
      <!-- <el-table-column label="动物图片" align="center" prop="imagePath" /> -->
      <el-table-column label="动物图片" align="center">
        <template slot-scope="scope">
          <!-- 拼接完整 URL，注意这里使用和第一段相同的前缀处理方式 -->
          <img 
            :src="'http://localhost:8080' + scope.row.imagePath" 
            style="width: 50px; height: 50px; object-fit: cover;"
          />
        </template>
      </el-table-column>
      <el-table-column label="详细情况说明" align="center" prop="reportDesc" />
      <el-table-column label="上报人" align="center" prop="userName" />
      <el-table-column label="上报时间" align="center" prop="reportTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.reportTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="当前状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pet_wander" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="预留号码" align="center" prop="phonenumber" />
      <el-table-column label="发现地" align="center" prop="discoveryLocation" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:wander:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:wander:remove']"
          >删除</el-button>
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

    <!-- 添加或修改流浪动物对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="动物图片" prop="imagePath">
          <el-input v-model="form.imagePath" placeholder="请输入动物图片" />
        </el-form-item>
        <el-form-item label="详细情况说明" prop="reportDesc">
          <el-input v-model="form.reportDesc" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="上报人" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入上报人用户名" />
        </el-form-item>
        <el-form-item label="上报时间" prop="reportTime">
          <el-date-picker clearable
            v-model="form.reportTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上报时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="当前状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择当前状态">
            <el-option
              v-for="dict in dict.type.sys_pet_wander"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="预留号码" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入预留号码" />
        </el-form-item>
        <el-form-item label="发现地点" prop="discoveryLocation">
          <el-input v-model="form.discoveryLocation" placeholder="请输入发现地" />
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
import { listWander, getWander, delWander, addWander, updateWander } from "@/api/system/wander";

export default {
  name: "Wander",
  dicts: ['sys_pet_wander'],
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
      // 流浪动物表格数据
      wanderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        reportTime: null,
        status: null,
        discoveryLocation: null,
        petId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        reportDesc: [
          { required: true, message: "发现宠物的详细情况说明不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "当前处理状态不能为空", trigger: "change" }
        ],
        discoveryLocation: [
          { required: true, message: "发现地点的详细文字描述不能为空", trigger: "blur" }
        ],
        petId: [
          { required: true, message: "关联宠物信息的宠物id不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询流浪动物列表 */
    getList() {
      this.loading = true;
      listWander(this.queryParams).then(response => {
        this.wanderList = response.rows;
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
        wanderId: null,
        imagePath: null,
        reportDesc: null,
        userName: null,
        reportTime: null,
        status: null,
        phonenumber: null,
        discoveryLocation: null,
        petId: null
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
      this.ids = selection.map(item => item.wanderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加流浪动物";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const wanderId = row.wanderId || this.ids
      getWander(wanderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改流浪动物";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.wanderId != null) {
            updateWander(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWander(this.form).then(response => {
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
      const wanderIds = row.wanderId || this.ids;
      this.$modal.confirm('是否确认删除流浪动物编号为"' + wanderIds + '"的数据项？').then(function() {
        return delWander(wanderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/wander/export', {
        ...this.queryParams
      }, `wander_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
