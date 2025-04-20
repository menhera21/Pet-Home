import request from '@/utils/request'

// 查询用品名称列表
export function listSupplies(query) {
  return request({
    url: '/system/supplies/list',
    method: 'get',
    params: query
  })
}

// 查询用品名称详细
export function getSupplies(supplyId) {
  return request({
    url: '/system/supplies/' + supplyId,
    method: 'get'
  })
}

// 新增用品名称
export function addSupplies(data) {
  return request({
    url: '/system/supplies',
    method: 'post',
    data: data
  })
}

// 修改用品名称
export function updateSupplies(data) {
  return request({
    url: '/system/supplies',
    method: 'put',
    data: data
  })
}

// 删除用品名称
export function delSupplies(supplyId) {
  return request({
    url: '/system/supplies/' + supplyId,
    method: 'delete'
  })
}
